package com.myapp.spring.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long code;
	
	String capital;
	
	String continent;
	
	Double GNP;
	
	long lifeExpectancy;
	
	String localName;
	
	String name;
	
	long population;
	
	String region;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="country",cascade=CascadeType.ALL)
	private Set<City> cities = new HashSet<>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="country",cascade=CascadeType.ALL)
	private Set<Language> languages = new HashSet<>();
	
	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(String capital, String continent, Double gNP, long lifeExpectancy, String localName, String name,
			long population, String region) {
		this.capital = capital;
		this.continent = continent;
		GNP = gNP;
		this.lifeExpectancy = lifeExpectancy;
		this.localName = localName;
		this.name = name;
		this.population = population;
		this.region = region;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Double getGNP() {
		return GNP;
	}

	public void setGNP(Double gNP) {
		GNP = gNP;
	}

	public long getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(long lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public long getCode() {
		return code;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((continent == null) ? 0 : continent.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Country))
			return false;
		Country other = (Country) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (continent == null) {
			if (other.continent != null)
				return false;
		} else if (!continent.equals(other.continent))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [code=");
		builder.append(code);
		builder.append(", capital=");
		builder.append(capital);
		builder.append(", continent=");
		builder.append(continent);
		builder.append(", GNP=");
		builder.append(GNP);
		builder.append(", lifeExpectancy=");
		builder.append(lifeExpectancy);
		builder.append(", localName=");
		builder.append(localName);
		builder.append(", name=");
		builder.append(name);
		builder.append(", population=");
		builder.append(population);
		builder.append(", region=");
		builder.append(region);
		builder.append("]");
		return builder.toString();
	}
	
	
}
