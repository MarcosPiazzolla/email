package br.com.piazzolla.mail;

public class Global {

  private final String emailUsuario;
  private final String senhaUsuario;
  private final String servidor;
  private final int porta;
  private final String arquivoAnexo;

  public Global(String emailUsuario, String senhaUsuario, String servidor,
      int porta, String arquivoAnexo) {
    this.emailUsuario = emailUsuario;
    this.senhaUsuario = senhaUsuario;
    this.servidor = servidor;
    this.porta = porta;
    this.arquivoAnexo = arquivoAnexo;
  }

  public String getEmailUsuario() {
    return emailUsuario;
  }

  public String getSenhaUsuario() {
    return senhaUsuario;
  }

  public String getServidor() {
    return servidor;
  }

  public int getPorta() {
    return porta;
  }

  public String getArquivoAnexo() {
    return arquivoAnexo;
  }

}