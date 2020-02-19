package com.emanon.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.emanon.entidades.EntidadProyecto;
import com.emanon.entidades.QEntidadProyecto;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLProyecto")
public class QueryDSLProyecto {
	
	private QEntidadProyecto qEntidadProyecto = QEntidadProyecto.entidadProyecto;
	@PersistenceContext
	private EntityManager em;
	
	
	public void find() {
		JPAQuery<EntidadProyecto> query = new JPAQuery<EntidadProyecto>();
		query.select(qEntidadProyecto).from(qEntidadProyecto).where(qEntidadProyecto.id_proyecto.eq(23)).fetchOne();
		
		List<EntidadProyecto> listaProyectos = query.select(qEntidadProyecto).from(qEntidadProyecto).where(qEntidadProyecto.horas.between(100, 200)).fetch();
	}
}
