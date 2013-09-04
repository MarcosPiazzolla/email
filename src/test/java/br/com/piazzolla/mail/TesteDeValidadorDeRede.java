package br.com.piazzolla.mail;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

@Test
public class TesteDeValidadorDeRede {

  public void deve_retornar_verdade_caso_haja_conectividade()
      throws MalformedURLException {
    boolean res = Validador.isConectado();

    assertThat(res, equalTo(true));
  }

}