package br.com.piazzolla.mail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validador {

  private static Logger logger = LogManager
      .getLogger(Validador.class.getName());

  public static boolean isConectado() {
    try {
      URL url = new URL("http://www.google.com");

      HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
      conexao.setRequestMethod("GET");

      int respostaHttp = conexao.getResponseCode();

      return respostaHttp != HttpURLConnection.HTTP_OK ? false : true;
    } catch (IOException e) {
      logger.info("Ocorreu um erro ao realizar a verifição de conectividade!");
    }
    return false;
  }

}