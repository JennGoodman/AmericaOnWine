package com.revature.americaonwine.data;

import java.util.List;

import com.revature.americaonwine.beans.Tag;

public interface TagDao {

	/**
	 * Add tag to the database.
	 * 
	 * @param tag
	 *            String to be inserted into the table
	 * @return tag that was updated
	 */
	public Tag save(Tag tag);

	/**
	 * Get list of all tags in the database
	 * 
	 * @return List<Tag> of tags
	 */
	public List<Tag> getAll();

	/**
	 * Get a list of tags belonging to a specific inventory item
	 * 
	 * @return List <Tag> of tags belonging to the given inventory id.
	 */
	public List<Tag> getAllByInventory(int inventoryId);

	/**
	 * Updates an existing tag in the db by ID.
	 * 
	 * @param id
	 *            of the tag to be updated
	 * @return tag that was updated
	 */
	public Tag update(Tag tag);

	/**
	 * Deletes an existing tag in the db by ID.
	 * 
	 * @param id
	 *            of the tag to be deleted
	 */
	public void delete(Tag tag);
}
