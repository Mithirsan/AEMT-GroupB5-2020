package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import be.helha.aemt.model.MessageType;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String sendEmail;
	private String subject;
	private MessageType messageType;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(String emailEnvoyeur, String sujet, MessageType messageType) {
		super();
		this.sendEmail = emailEnvoyeur;
		this.subject = sujet;
		this.messageType = messageType;
	}

	public String getEmailEnvoyeur() {
		return sendEmail;
	}

	public void setEmailEnvoyeur(String emailEnvoyeur) {
		this.sendEmail = emailEnvoyeur;
	}

	public String getSujet() {
		return subject;
	}

	public void setSujet(String sujet) {
		this.subject = sujet;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", emailEnvoyeur=" + sendEmail + ", sujet=" + subject + ", messageType="
				+ messageType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sendEmail == null) ? 0 : sendEmail.hashCode());
		result = prime * result + ((messageType == null) ? 0 : messageType.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (sendEmail == null) {
			if (other.sendEmail != null)
				return false;
		} else if (!sendEmail.equals(other.sendEmail))
			return false;
		if (messageType != other.messageType)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	
	
	
	

}
