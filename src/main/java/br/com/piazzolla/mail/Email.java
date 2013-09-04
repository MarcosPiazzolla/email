package br.com.piazzolla.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.joda.time.LocalDate;

public class Email {

  private final Global global;

  public Email(Global global) {
    this.global = global;
  }

  public boolean enviar() {
    EmailAttachment anexo = new EmailAttachment();

    anexo.setPath(global.getArquivoAnexo());
    anexo.setDisposition(EmailAttachment.ATTACHMENT);

    MultiPartEmail email = new MultiPartEmail();

    email.setHostName(global.getServidor());
    email.setSmtpPort(global.getPorta());
    email.setAuthenticator(new DefaultAuthenticator(global.getEmailUsuario(),
        global.getSenhaUsuario()));
    email.setSSLOnConnect(true);

    try {
      String mensagem = String.format("Backup referente ao dia %s",
          LocalDate.now().toString("dd-MM-yyyy"));

      email.setFrom(global.getEmailUsuario());
      email.setSubject("Diretiva de Backup");
      email.setMsg(mensagem);
      email.addTo(global.getEmailUsuario());
      email.attach(anexo);

      email.send();

      return true;
    } catch (EmailException e) {
      return false;
    }

  }

}