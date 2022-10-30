/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:  think of what type of keys and values would best suit the requirements
     */
    private final Map<String, Set<U>> followedUsers;
    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.followedUsers = new HashMap<>();
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */

    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
        this.followedUsers = new HashMap<>();
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        Set<U> users = this.followedUsers.get(circle);                       //Get users in group (circle)
        if(users == null) {
            users = new HashSet<>();                                        //If group doesn't exist, create it
            this.followedUsers.put(circle, users);                          //And add it to the map of friends
        }
        return users.add(user);                                             //Add user to group
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        final Collection<U> users = this.followedUsers.get(groupName);      //Get users in group
        if(users == null) {
            return Collections.emptyList();                                 //If group doesn't exist, return empty list
        }
        return new ArrayList<>(users);                                      //Else return a list of the users in specified group 
    }

    @Override
    public List<U> getFollowedUsers() {
        final Set<U> users = new HashSet<>();               //Create a set of users to store users in groups
        for(final Set<U> group : followedUsers.values()) {  //Iterate the map
            users.addAll(group);                            //Add all users in group to set
        }
        return new ArrayList<>(users);                      //Return a list of the users in all groups
    }
}
