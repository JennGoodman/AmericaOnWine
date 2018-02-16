package com.revature.americaonwine.data;

import java.util.List;


public interface InventoryAuditDao {

	/**
	 * Get list of all Inventory Audits in the database
	 * 
	 * @return List<InventoryAudit> of Inventory Audits
	 */
	public List<?> getAll();

	/**
	 * Get list of Inventory Audits for a specific inventory item
	 * 
	 * @return List<InventoryAudit> of Inventory Audits
	 */
	public List<?> getByInventoryId();
}
