package com.revature.americaonwine.data;

import java.util.List;

import com.revature.americaonwine.beans.Country;

public interface CountryDao {

	/**
	 * Save country to the database.
	 * 
	 * @param Country
	 *            to be added to the database
	 * @return Country added
	 */
	public Country save(Country country);

	/**
	 * Get list of all countries in the database
	 * 
	 * @return List<Country> of countries
	 */
	public List<?> getAll();

	/**
	 * Updates an existing country in the database.
	 * 
	 * @param Country
	 *            to be updated
	 * @return Country updated
	 */
	public Country update(Country country);

	/**
	 * Deletes an existing country from the database.
	 * 
	 * @param Country
	 *            to be deleted
	 */
	public void delete(Country country);
}
