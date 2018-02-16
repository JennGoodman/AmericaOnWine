package com.revature.americaonwine.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Brand;

@Component
public interface BrandDao {

	/**
	 * Save brand to the database.
	 * 
	 * @param Brand
	 *            to be added to the database
	 * @return Brand added
	 */
	public Brand save(Brand brand);

	/**
	 * Get list of all brands in the database
	 * 
	 * @return List<Brand> of brands
	 */
	public List<Brand> getAll();

	/**
	 * Updates an existing brand in the database.
	 * 
	 * @param Brand
	 *            to be updated
	 * @return Brand updated
	 */
	public Brand update(Brand brand);

	/**
	 * Deletes an existing brand from the database.
	 * 
	 * @param Brand
	 *            to be deleted
	 */
	public void delete(Brand brand);
}
