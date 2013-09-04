package br.com.piazzolla.mail;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

@Test
public class TesteDeGlobal {

  private Global global;

  @SuppressWarnings("resource")
  public void global_deve_ser_criado_via_xml() {
    assertThat(global, is(nullValue()));

    ApplicationContext context;
    context = new ClassPathXmlApplicationContext(
        "applicationContext.xml");

    global = (Global) context.getBean("global");

    assertThat(global.getEmailUsuario(), equalTo("piazzolla.marcos@gmail.com"));
    assertThat(global.getSenhaUsuario(), equalTo("robocopgay"));
    assertThat(global.getServidor(), equalTo("smtp.googlemail.com"));
    assertThat(global.getPorta(), equalTo(465));
    assertThat(
        global.getArquivoAnexo(),
        equalTo("/home/marcos/Documents/projetos/email/src/test/resources/backup.rar"));
  }

}