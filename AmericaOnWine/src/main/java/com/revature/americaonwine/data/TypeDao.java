package com.revature.americaonwine.data;

import java.util.List;

import com.revature.americaonwine.beans.Type;

public interface TypeDao {

	/**
	 * Save type to the database.
	 * 
	 * @param Type
	 *            to be added to the database
	 * @return Type added
	 */
	public Type save(Type type);

	/**
	 * Get list of all types in the database
	 * 
	 * @return List<Type> of types
	 */
	public List<Type> getAll();

	/**
	 * Updates an existing type in the database.
	 * 
	 * @param Type
	 *            to be updated
	 * @return Type updated
	 */
	public Type update(Type type);

	/**
	 * Deletes an existing type from the database.
	 * 
	 * @param Type
	 *            to be deleted
	 */
	public void delete(Type type);
}