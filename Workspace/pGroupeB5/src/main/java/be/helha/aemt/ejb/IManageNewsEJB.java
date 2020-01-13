package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.News;

@Remote
public interface IManageNewsEJB {

	public List<News> findAll();
}
