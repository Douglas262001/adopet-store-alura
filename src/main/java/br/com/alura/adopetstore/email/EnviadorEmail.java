package br.com.alura.adopetstore.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EnviadorEmail {

    @Autowired
    private JavaMailSender emailSender;

    public void enviarEmail(String assunto, String destinatario, String textoEmail) {

        try {
            var email = new SimpleMailMessage();

            String meuEmail = System.getenv("MEU_EMAIL");

            email.setFrom(meuEmail);
            email.setSubject(assunto);
            email.setTo(meuEmail);
            email.setText(textoEmail);
            emailSender.send(email);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar email!", e);
        }
    }

}
