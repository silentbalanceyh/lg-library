package org.lg.ce.model;

import java.io.Serializable;

import org.lg.ce.json.JsonObject;
import org.lg.em.Etat;
import org.lg.hors.AbstractException;

public class Envelop implements Serializable{
	
	private transient JsonObject data = new JsonObject();
	private transient JsonObject metadata = new JsonObject();
	private transient AbstractException error;
	private transient Etat status = Etat.UNKNOWN;
	
	// ---------------- Public Api ---------------------------
	public boolean isValid(){
		return Etat.VALID == this.status && null == this.error;
	}
	
	public JsonObject getData(){
		return this.data;
	}
	
	public JsonObject getMeta(){
		return this.metadata;
	}
	
	public AbstractException getError(){
		return this.error;
	}
	
	public Etat getStatus(){
		return this.status;
	}
}
