package com.viadeo.scalamata

import scala.concurrent.duration.FiniteDuration
import java.util.concurrent.TimeUnit

/* 
	for more documentation about project naming please check
   	http://en.wikipedia.org/wiki/Kalamata_(olive)
*/

object MataMain extends App {
	
	val emailService = EmailService
	
	val smtpConfig = new SmtpConfig(
			tls = true,
			port = 587,
			host = "smtp.sendgrid.net",
			user = "insertuser",
			password = "insertpassword"
		)

	val myMessage = new EmailMessage(
			subject = "Holly Moolox",
			recipient = "datadriven@viadeoteam.com",
            from = "flelay@viadeoteam.com",
            text = Some("Akka based mailer - you can rock this!!!"),
            html = Some("<html><head><title>Holly Moolox</title></head><body><b>Akka based mailer - You can rock this</b></body></html>"),
            smtpConfig = smtpConfig,
            retryOn = new FiniteDuration(30, TimeUnit.SECONDS)
		)
	
	emailService.send(myMessage)

}