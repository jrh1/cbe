package cbe.fetching;

import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.SelectQuery;

import cbe.fetching.model.Person;
import cbe.fetching.utilities.CountHelper;
import cbe.fetching.utilities.Populator;

/**
 * Cayenne By Example - https://github.com/mrg/cbe
 *
 * This example builds upon BasicInserts3.
 *
 * It counts how many Person objects are in the database.
 *
 * @author mrg
 */
public class Counting
{
    public static void main(String[] arguments)
    {
        // Create a new DataContext. This will also initialize the Cayenne
        // Framework.
        DataContext dataContext = DataContext.createDataContext();

        // Loop over all the names in our resources file and create Persons
        // for each of them.
        for (String[] personFields : Populator.getPeople())
            createPerson(dataContext, personFields);

        // Commit the changes to the database.
        dataContext.commitChanges();

        SelectQuery query = new SelectQuery(Person.class);

        System.out.println("Number of persons: " + CountHelper.count(dataContext, query));

        Expression expression = ExpressionFactory.likeIgnoreCaseExp(Person.FIRST_NAME_PROPERTY, "A%");
        query.setQualifier(expression);

        System.out.println("Number of persons: " + CountHelper.count(dataContext, query));
    }

    /**
     * Helper method to create and initialize a person in a DataContext.
     *
     * @param dataContext The DataContext to register the person.
     * @param fields The data fields from the People.txt file.
     */
    private static void createPerson(DataContext dataContext, String[] fields)
    {
    	// Extract field values.
    	String firstName    = fields[Populator.PERSON_FIRST_NAME];
    	String lastName     = fields[Populator.PERSON_LAST_NAME];
    	String emailAddress = fields[Populator.PERSON_EMAIL_ADDRESS];

        // Create a new Person object tracked by the DataContext.
    	Person person = dataContext.newObject(Person.class);

        // Set values for the new person. Defaults the password to the e-mail
        // address with "123" appended.
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmailAddress(emailAddress);
        person.setPassword(emailAddress + "123");
    }
}