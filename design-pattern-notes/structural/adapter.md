# Adapter design pattern
- The Adapter Design Pattern is used to allow two `incompatible interfaces` to work together.
- It acts as a bridge between the two interfaces.
- It translates requests from one interface into a format that the other interface can understand.
- Consider the below example.
  - A web application which fetches weather based on zipcode.
  - The backend of the application relies on WeatherFinder service which takes `city` as input and returns weather.
  - We need an adapter which takes input of zipcode and converts into `city` and fetches information from WeatherFinder.
- Here is the code for the same.
```java
public interface WeatherFinder {
	int find(String city);
}

public class WeatherFinderImpl implements WeatherFinder {
	@Override
	public int find(String city) {
		return 33;
	}
}

public class WeatherAdapter {
	public int findTemperature(int zipCode) {
		String city = null;
		if (zipCode == 19406) {
			city = "King Of Prussia";
		}
		WeatherFinder finder = new WeatherFinderImpl();
		int temperature = finder.find(city);
		return temperature;
	}
}

public class WeatherUI {
	public void showTemperature(int zipcode) {
		WeatherAdapter adapter = new WeatherAdapter();
		System.out.println(adapter.findTemperature(zipcode));

	}

	public static void main(String[] args) {
		WeatherUI ui = new WeatherUI();
		ui.showTemperature(19406);
	}
}
```
- Here is the UML class diagram for the above code.

<img src="../../images/adapter.png" height=300 width=400>

- Other examples.
  - `RestTemplate:` rest template acts as an adapter between spring and httpclient implementation.
    - It provides a high-level API for making HTTP request such as getForEntity(), postForEntity(), marshalling/unmarshalling.
  - `Arrays.asList()`
    - This utility method acts as an adapter between the array and List interface. It wraps the array into a List.
      - `Note:` This returns an immutable list, meaning you can't invoke some methods like add(), remove() etc.
  
- `Note:`
  - The Adapter pattern does not necessarily require the adapter to return the interface type of the adaptee to the caller.
  - The purpose of the Adapter pattern is to allow objects with incompatible interfaces to work together. 
  - How the adapter interacts with the adaptee and what it returns to the caller depends on the specific requirements and design of the 
    system.
  - For ex, in the WeatherAdapter example, it returns an integer representing the temperature, which is the result of calling the 
    findTemperature() method.