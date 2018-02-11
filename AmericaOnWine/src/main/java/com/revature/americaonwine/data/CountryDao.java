package com.revature.americaonwine.data;

import java.util.List;

import com.revature.americaonwine.beans.Country;

public interface CountryDao {

	/**
	 * Add country to the database.
	 * 
	 * @param country
	 *            String to be inserted into the table
	 * @return the id of the country added
	 */
	public int addCountry(String country);

	/**
	 * Get list of all countries in the database
	 * 
	 * @return List<Country> of countries
	 */
	public List<Country> getAllCountries();

	/**
	 * Updates an existing country in the db by ID.
	 * 
	 * @param id
	 *            of the country to be updated
	 * @return true if successful, false otherwise
	 */
	public boolean updateCountry(int id);

	/**
	 * Deletes an existing country in the db by ID.
	 * 
	 * @param id
	 *            of the country to be deleted
	 * @return true if successful, false otherwise
	 */
	public boolean deleteCountry(int id);
}
