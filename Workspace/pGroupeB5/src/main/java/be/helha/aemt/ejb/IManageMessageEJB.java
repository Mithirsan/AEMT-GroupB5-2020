package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Message;

@Remote
public interface IManageMessageEJB {

	public List<Message> findAll();
}
