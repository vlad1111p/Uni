import java.util.*;

public class Store {
	static List<Article> search(List<Article> l, String s) {
		List<Article> liste = new ArrayList<Article>();
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getName().contains(s) || l.get(i).getDescription().contains(s)) {
				liste.add(l.get(i));
			}
		}
		return liste;
	}
	
	static long price(Order o) {
		List<Article> liste = new ArrayList<Article>();
		liste = o.getArticles();
		long price = 0;
		for(int i=0; i<liste.size(); i++) {
			price = price + liste.get(i).getPrice();
		}
		return price;
	}
	
	static Set<Article> neverOrdered(List<Article> articles, List<Order> orders) {
		Set<Article> ausgabe = new LinkedHashSet<>();
		boolean check = true;
		int counter = 0;
		
		for(int i=0; i<articles.size(); i++) {
			if(check == false) {
				ausgabe.add(articles.get(i-1));
			}
			check = false;
			counter++;
			for(int z=0; z<orders.size(); z++) {
				for(int jott=0; jott<orders.get(z).getArticles().size(); jott++) {
					
					if(articles.get(i).getName().equals(orders.get(z).getArticles().get(jott).getName())) {
						check = true;
					}
					
				}
			}
		}
		if(check == false) {
			ausgabe.add(articles.get(counter-1));
		}
		return ausgabe;
	}
	
	static Map<User, List<Article>> articlesByUser(List<Order> orders) {
		Map<User, List<Article>> ausgabe = new HashMap<>();
		List<User> names = new ArrayList<User>();
		for(int i=0; i<orders.size(); i++) {
			if(!names.contains(orders.get(i).getUser())) {
				names.add(orders.get(i).getUser());
			}
		}

		for(int i=0; i<names.size(); i++) {
			List<Article> artikel = new ArrayList<Article>();
			for(int z=0; z<orders.size(); z++) {
				if(names.get(i).equals(orders.get(z).getUser())) {
					for(int jott=0; jott < orders.get(z).getArticles().size(); jott++) {
						artikel.add(orders.get(z).getArticles().get(jott));
					}
				}
			}
		ausgabe.put(names.get(i), artikel);
		}

		return ausgabe;
		
	}
	
	static List<Order> mergeOrders(List<Order> orders) {
		Map<User, List<Article>> map = articlesByUser(orders);
		List<Order> ausgabe = new ArrayList<Order>();
		for(int i=0; i<map.size(); i++) {
				ausgabe.add(new OrderImpl(map.get(orders.get(i).getUser()), orders.get(i).getUser()));
		}
		return ausgabe;
	}
}
