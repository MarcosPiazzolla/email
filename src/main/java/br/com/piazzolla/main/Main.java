package br.com.piazzolla.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.piazzolla.mail.Email;
import br.com.piazzolla.mail.Global;

public class Main {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    System.out.println("Enviando email.....");

    ApplicationContext context = new ClassPathXmlApplicationContext(
        "applicationContext.xml");
    Global global = (Global) context.getBean("global");

    Email email = new Email(global);

    email.enviar();
  }

}
