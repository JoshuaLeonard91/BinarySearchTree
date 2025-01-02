/**
 * <b>COP 3530: Project 4 – Stacks and Priority Queues with Linked Lists </b>
 * <p>
 * This class creates a country object that consists of the countrys name,
 * capital, population, gdp, covid cases, covid deaths and countrys size(area).
 * It also provides getter and setter methods and seven other methods, two that
 * return formatted strings,and 5 more that return the calculations
 * specified.<br>
 * <br>
 * Methods:<br>
 * <br>
 * 
 * <pre>
 * {@linkplain #getData() getData}: returns a string formatted for spaced columns to be print out by an array in the main class file.
 * {@linkplain #getGDPPC() getGDPPC}: GDP per capita
 * {@linkplain #getCaseRate() getCaseRate}: Case rate
 * {@linkplain #getDeathRate() getDeathRate}: Death Rate
 * {@linkplain #getCFR() getCFR}: Covid fatality rate
 * {@linkplain #getPopDens() getPopDens}: Population density
 * Also includes Getters and Setters for the object for all variables.
 * </pre>
 * 
 * @author Joshua Leonard
 * @version 11/12/2022
 */
public class Country {

	private String name;
	private String capital;
	private double population;
	private double gdp;
	private double covidCase;
	private double covidDeath;
	private double area;

	/**
	 * Constructor that takes in a countries name, capital, population, gdp, covid
	 * cases, and covid deaths.
	 * 
	 * @param name       Country Name
	 * @param capital    Country Capital
	 * @param population Country Population
	 * @param gdp        Country GDP
	 * @param covidCase  Country Covid Cases
	 * @param covidDeath Country Covid Deaths
	 * @param area       Country Area
	 */
	public Country(String name, String capital, double population, double gdp, double covidCase, double covidDeath,
			double area) {
		super();
		this.name = name;
		this.capital = capital;
		this.population = population;
		this.gdp = gdp;
		this.covidCase = covidCase;
		this.covidDeath = covidDeath;
		this.area = area;
	}// end constructor

	/**
	 * method to return country name
	 * 
	 * @return the Country name
	 */
	public String getName() {
		return name;
	}// end getName

	/**
	 * method to return country capital
	 * 
	 * @return the Country capital
	 */
	public String getCapital() {
		return capital;
	}// end getCapital

	/**
	 * method to return country population
	 * 
	 * @return the Country population
	 */
	public double getPopulation() {
		return population;
	}// end getPopulation

	/**
	 * method to return country gdp
	 * 
	 * @return the Country gdp
	 */
	public double getGdp() {
		return gdp;
	}// end getGdp

	/**
	 * method to return country covid cases
	 * 
	 * @return the Country covidCase
	 */
	public double getCovidCase() {
		return covidCase;
	}// end getCovidCase

	/**
	 * method to return country covid deaths
	 * 
	 * @return the Country covidDeath
	 */
	public double getCovidDeath() {
		return covidDeath;
	}// end getCovidDeath

	/**
	 * Returns the are (size of country)
	 * 
	 * @return the Country area
	 */
	public double getArea() {
		return area;
	}// end getArea

	/**
	 * Calculates GDP per capita
	 * 
	 * @return double
	 */

	/**
	 * Takes in a string
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}// end setName

	/**
	 * Takes in a string
	 * 
	 * @param capital the capital to set
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}// end setCapital

	/**
	 * Takes in a double
	 * 
	 * @param population the population to set
	 */
	public void setPopulation(double population) {
		this.population = population;
	}// end setPopulation

	/**
	 * Takes in a double
	 * 
	 * @param gdp the gdp to set
	 */
	public void setGdp(double gdp) {
		this.gdp = gdp;
	}// end setGDP

	/**
	 * Takes in a double
	 * 
	 * @param covidCase the covidCase to set
	 */
	public void setCovidCase(double covidCase) {
		this.covidCase = covidCase;
	}// end setCovidCase

	/**
	 * Takes in a double
	 * 
	 * @param covidDeath the covidDeath to set
	 */
	public void setCovidDeath(double covidDeath) {
		this.covidDeath = covidDeath;
	}// end setCovidDeath

	/**
	 * Takes in a double
	 * 
	 * @param area the area to set
	 */
	public void setArea(double area) {
		this.area = area;
	}// end setArea

	public double getGDPPC() {
		return (getGdp() / getPopulation());
	}// end getGDPPC

	/**
	 * Calculates case fatality rate
	 * 
	 * @return double
	 */
	public double getCFR() {
		return (getCovidDeath() / getCovidCase());
	}// end getCFR

	/**
	 * Calculates case rate
	 * 
	 * @return double
	 */
	public double getCaseRate() {
		return (getCovidCase() / (getPopulation()) * 100000);
	}// end getCaseRate

	/**
	 * Calculates death rate
	 * 
	 * @return double
	 */
	public double getDeathRate() {
		return (getCovidDeath() / (getPopulation()) * 100000);
	}// end getDeathRate

	/**
	 * Calculates population density
	 * 
	 * @return double
	 */
	public double getPopDens() {
		return (getPopulation() / getArea());
	}// end getPopDens

	@Override
	/**
	 * When called it will print out a countrys data.
	 * <p>
	 * Not used in program, but can be used to debug.
	 * 
	 * @return string that contains all data in the object
	 */
	public String toString() {
		return "Country [name=" + name + ", capital=" + capital + ", population=" + population + ", gdp=" + gdp
				+ ", covidCase=" + covidCase + ", covidDeath=" + covidDeath + ", area=" + area + "]";
	}

	/**
	 * This method will return a formatted string, name, capital, GDP per capita,
	 * case fatality rates, case rates, death rates, and population density.<br>
	 * The format is similar to columns. Example<br>
	 * <b>NAME CAPTIAL GDPPC CASERATE DEATHRATE POPDENS</b><br>
	 * <br>
	 * GDPPC: gdp/population <br>
	 * CFR: deaths/cases <br>
	 * Case rates: case/population<br>
	 * Death rates: deaths/population<br>
	 * Population density: population/area<br>
	 * 
	 * @return formatted string
	 */
	public String getData() {
		return String.format("%-32s", getName()) + String.format("%15.16s", getCapital())
				+ String.format("%13.13s", String.format("%.3f", getGdp() / getPopulation()))
				+ String.format("%13.13s", String.format("%.6f", getCovidDeath() / getCovidCase()))
				+ String.format("%13.13s", String.format("%.3f", (getCovidCase() / getPopulation()) * 100000))
				+ String.format("%13.13s", String.format("%.3f", (getCovidDeath() / getPopulation()) * 100000))
				+ String.format("%13.13s", String.format("%.3f", getPopulation() / getArea()));
	}// end getData

	public String getDataTwo() {
		return String.format("%-32s", getName())
				+ String.format("%13.13s", String.format("%.3f", getGdp() / getPopulation()));
	}

}
