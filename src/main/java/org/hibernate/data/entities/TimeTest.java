package org.hibernate.data.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @Temporal se usa para escpcificar que quieres mostrar la hora o solo la fecha y
 * solo puede ser usado con un atributo de tipo Date o con Calendar
 * */

@Entity
@Table(name="time_test")
public class TimeTest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TIME_TEST_ID")
	private Long timeTestId;
	
	@Column(name="DATETIME_COLUMN")
	private LocalDateTime datetimeColumn;
	
	@Column(name="TIMESTAMP_COLUMN")
	private LocalTime timestampColumn;
	
	@Column(name="DATE_COLUMN")
	private LocalDate dateColumn;
	
	@Column(name="TIME_COLUMN")
	private LocalTime timeColumn;
	
	@Column(name="SQL_DATETIME_COLUMN")
	private LocalDateTime sqlDatetimeColumn;
	
	@Column(name="SQL_TIMESTAMP_COLUMN")
	private LocalTime sqlTimestampColumn;
	
	@Column(name="SQL_DATE_COLUMN")
	private LocalDate sqlDateColumn;
	
	@Column(name="SQL_TIME_COLUMN")
	private LocalTime sqlTimeColumn;
	
	
	
	public TimeTest() {
		
	}

	public TimeTest(LocalDateTime localDateTime) {
		this.datetimeColumn = localDateTime;
		this.timestampColumn = localDateTime.toLocalTime();
		this.dateColumn = localDateTime.toLocalDate();
		this.timeColumn = localDateTime.toLocalTime();
		this.sqlDatetimeColumn = localDateTime;
		this.sqlTimestampColumn = localDateTime.toLocalTime();
		this.sqlDateColumn = localDateTime.toLocalDate();
		this.sqlTimeColumn = localDateTime.toLocalTime();
	}

	public Long getTimeTestId() {
		return timeTestId;
	}

	public void setTimeTestId(Long timeTestId) {
		this.timeTestId = timeTestId;
	}

	public LocalDateTime getDatetimeColumn() {
		return datetimeColumn;
	}

	public void setDatetimeColumn(LocalDateTime datetimeColumn) {
		this.datetimeColumn = datetimeColumn;
	}

	public LocalTime getTimestampColumn() {
		return timestampColumn;
	}

	public void setTimestampColumn(LocalTime timestampColumn) {
		this.timestampColumn = timestampColumn;
	}

	public LocalDate getDateColumn() {
		return dateColumn;
	}

	public void setDateColumn(LocalDate dateColumn) {
		this.dateColumn = dateColumn;
	}

	public LocalTime getTimeColumn() {
		return timeColumn;
	}

	public void setTimeColumn(LocalTime timeColumn) {
		this.timeColumn = timeColumn;
	}

	public LocalDateTime getSqlDatetimeColumn() {
		return sqlDatetimeColumn;
	}

	public void setSqlDatetimeColumn(LocalDateTime sqlDatetimeColumn) {
		this.sqlDatetimeColumn = sqlDatetimeColumn;
	}

	public LocalTime getSqlTimestampColumn() {
		return sqlTimestampColumn;
	}

	public void setSqlTimestampColumn(LocalTime sqlTimestampColumn) {
		this.sqlTimestampColumn = sqlTimestampColumn;
	}

	public LocalDate getSqlDateColumn() {
		return sqlDateColumn;
	}

	public void setSqlDateColumn(LocalDate sqlDateColumn) {
		this.sqlDateColumn = sqlDateColumn;
	}

	public LocalTime getSqlTimeColumn() {
		return sqlTimeColumn;
	}

	public void setSqlTimeColumn(LocalTime sqlTimeColumn) {
		this.sqlTimeColumn = sqlTimeColumn;
	}

	@Override
	public String toString() {
		return "TimeTest [timeTestId=" + timeTestId + ", datetimeColumn=" + datetimeColumn + ", timestampColumn="
				+ timestampColumn + ", dateColumn=" + dateColumn + ", timeColumn=" + timeColumn + ", sqlDatetimeColumn="
				+ sqlDatetimeColumn + ", sqlTimestampColumn=" + sqlTimestampColumn + ", sqlDateColumn=" + sqlDateColumn
				+ ", sqlTimeColumn=" + sqlTimeColumn + "]";
	}
	
	
}
