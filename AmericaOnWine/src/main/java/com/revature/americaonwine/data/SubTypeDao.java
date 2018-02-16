package com.revature.americaonwine.data;

import java.util.List;

import com.revature.americaonwine.beans.SubType;

public interface SubTypeDao {

	/**
	 * Save subType to the database.
	 * 
	 * @param SubType
	 *            to be added to the database
	 * @return SubType added
	 */
	public SubType save(SubType subType);

	/**
	 * Get list of all subTypes in the database
	 * 
	 * @return List<SubType> of subTypes
	 */
	public List<SubType> getAll();

	/**
	 * Updates an existing subType in the database.
	 * 
	 * @param SubType
	 *            to be updated
	 * @return SubType updated
	 */
	public SubType update(SubType subType);

	/**
	 * Deletes an existing subType from the database.
	 * 
	 * @param SubType
	 *            to be deleted
	 */
	public void delete(SubType subType);
}
