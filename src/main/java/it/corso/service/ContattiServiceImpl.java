package it.corso.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.ContattiDao;
import it.corso.model.Contatti;

@Service
public class ContattiServiceImpl implements ContattiService 
{

	@Autowired
	private ContattiDao contattiDao;
	
	@Override
	public void registraContatti(Contatti contatti) 
	{
		contattiDao.save(contatti);
	}

	@Override
	public Contatti getContattiById(int id) 
	{

		return contattiDao.findById(id).get();
	}

	@Override
	public List<Contatti> getAllContatti() 
	{

		return (List<Contatti>) contattiDao.findAll();
	}

	@Override
	public void cancellaContatti(Contatti contatti) 
	{
		contattiDao.delete(contatti);
	}

}
