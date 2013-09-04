package br.com.piazzolla.mail;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

@Test
public class TesteDeEmail {

  private Email email;

  @SuppressWarnings("resource")
  public void envio_deve_ocorrer() {
    AbstractXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "applicationContext.xml");

    Global global = (Global) context.getBean("global");

    email = new Email(global);
    boolean status = email.enviar();

    assertThat(status, is(true));
  }

}