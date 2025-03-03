package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker=new Faker();
	public String createUsername()
	{
		return faker.name().username();
	}
	public String createPassword()
	{
		return faker.internet().password();
	}
	public String createFullName()
	{
		return faker.name().fullName();
	}
	public String createEmailID()
	{
		return faker.internet().emailAddress();
	}
	public String createAddress()
	{
		return faker.address().fullAddress();
	}

}
