package de.bananaco.permissions.util;

import java.util.HashSet;
import java.util.Set;

import de.bananaco.permissions.set.WorldPermissionSet;

public abstract class Calculable extends GroupCarrier {
	
	
	Set<Permission> effectivePermissions;
	String name;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Calculable(String name, Set<String> groups, Set<Permission> permissions, WorldPermissionSet parent) {
		super(parent, groups, permissions);
		this.name = name;
		this.effectivePermissions = new HashSet();
	}

	/**
	 * Used to calculate the total permissions gained by the object
	 */
	public void calculateEffectivePermissions() {
		effectivePermissions.clear();
		effectivePermissions.addAll(getPermissions());
		for(Group group : getGroups()) {
			effectivePermissions.addAll(group.getEffectivePermissions());
		}
	}

	/**
	 * Return the total permissions gained by the object
	 * @return Set<Permission>
	 */
	public Set<Permission> getEffectivePermissions() {
		return effectivePermissions;
	}
	/**
	 * Returns the name of the calculable object
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
}