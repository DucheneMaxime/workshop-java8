package java8.ex02;

import java8.data.Account;
import java8.data.Person;
import org.junit.Test;

import java.util.function.BiFunction;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 02 - java.util.function.BiFunction
 */
public class Function_02_Test {

    //  tag::buildAccount[]
    BiFunction<Person, Integer, Account> buildAccount = (p, s) -> {
    	Account a = new Account();
    	a.setBalance(s);
    	a.setOwner(p);
    	return a;
    };
    //  end::buildAccount[]

    @Test
    public void test_build_account() throws Exception {

        // TODO invoquer la fonction buildAccount pour que le test soit passant
    	Person p = new Person();
    	p.setAge(80);
    	p.setFirstname("John");
    	p.setLastname("France");
    	p.setPassword("pass");
        Account account = buildAccount.apply(p,  500);

        assertThat(account, hasProperty("balance", is(500)));
        assertThat(account.getOwner(), hasProperty("firstname", is("John")));
        assertThat(account.getOwner(), hasProperty("lastname", is("France")));
        assertThat(account.getOwner(), hasProperty("age", is(80)));
        assertThat(account.getOwner(), hasProperty("password", is("pass")));
    }


}
