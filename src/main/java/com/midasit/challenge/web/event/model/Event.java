package com.midasit.challenge.web.event.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EVENT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id", updatable = false, nullable = false)
	private int event_id;
	
	@Column(name = "type", updatable = false, nullable = false)
	private String type;

	@Column(name = "menu_id", updatable = false, nullable = false)
	private String menu_id;

	@Column(name = "start_date", updatable = false, nullable = false)
	private Timestamp start_date;

	@Column(name = "end_date", updatable = false, nullable = false)
	private Timestamp end_date;

	public void update(Event event) {
		this.type = event.type;
		this.menu_id = event.menu_id;
		this.start_date = event.start_date;
		this.end_date = event.end_date;
		this.type = event.type;
	}
}
