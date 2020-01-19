package com.seller.portal.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.seller.portal.model.Role;
import com.seller.portal.model.User;
import com.seller.portal.repository.RoleRepository;
import com.seller.portal.repository.UserRepository;


@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	

	@Override
	public void saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = roleRepository.findByRole("SITE_USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
	@Override
	public void updateUser(User user) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
//		User user1  = (User) authentication.getPrincipal();
//		int id = user1.getId();
		long a=userRepository.count();
		 Optional<User> employee = userRepository.findById((int)a);
		 //System.out.println("count"+userRepository.count());
		// System.out.println("value id"+id);
		 employee.ifPresent(consumer->{
			// user.setName(consumer.getName());
		user.setAccount(consumer.getAccount());
		user.setEmail(consumer.getEmail());
		user.setPassword((consumer.getPassword()));
		//System.out.println("passwrd"+encoder.encode(consumer.getPassword()));
		user.setId(consumer.getId());
		user.setLastName(consumer.getLastName());
		user.setMobile(consumer.getMobile());
		user.setName(consumer.getName());
		user.setShop(consumer.getShop());
		user.setStatus(consumer.getStatus());
		 });
		 userRepository.save(user);
	}
	
	@Override
	public void updateIdentity(User user) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
//		User user1  = (User) authentication.getPrincipal();
//		int id = user1.getId();
		long a=userRepository.count();
		 Optional<User> employee = userRepository.findById((int)a);
		 //System.out.println("count"+userRepository.count());
		// System.out.println("value id"+id);
		 employee.ifPresent(consumer->{
			// user.setName(consumer.getName());
		user.setAccount(consumer.getAccount());
		user.setEmail(consumer.getEmail());
		user.setPassword((consumer.getPassword()));
		//user.setPassword(encoder.encode(consumer.getPassword()));
		user.setId(consumer.getId());
		user.setLastName(consumer.getLastName());
		user.setMobile(consumer.getMobile());
		user.setName(consumer.getName());
		user.setShop(consumer.getShop());
		user.setStatus(consumer.getStatus());
		user.setLine1(consumer.getLine1());
		user.setLine2(consumer.getLine2());
		user.setCity(consumer.getCity());
		user.setCode(consumer.getCode());
		 });
		 userRepository.save(user);
	}
	
		@Override
		public void updateBank(User user) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalName = authentication.getName();
			
	//		User user1  = (User) authentication.getPrincipal();
	//		int id = user1.getId();
			long a=userRepository.count();
			 Optional<User> employee = userRepository.findById((int)a);
			 //System.out.println("count"+userRepository.count());
			// System.out.println("value id"+id);
			 employee.ifPresent(consumer->{
				// user.setName(consumer.getName());
			user.setAccount(consumer.getAccount());
			user.setEmail(consumer.getEmail());
			user.setPassword((consumer.getPassword()));
			//user.setPassword(encoder.encode(consumer.getPassword()));
			user.setId(consumer.getId());
			user.setLastName(consumer.getLastName());
			user.setMobile(consumer.getMobile());
			user.setName(consumer.getName());
			user.setShop(consumer.getShop());
			user.setStatus(consumer.getStatus());
			user.setLine1(consumer.getLine1());
			user.setLine2(consumer.getLine2());
			user.setCity(consumer.getCity());
			user.setCode(consumer.getCode());
			user.setDocument(consumer.getDocument());
			user.setDocnum(consumer.getDocnum());
			 });
			 userRepository.save(user);
		}
	
	@Override
	public void updatePassword(User user) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
//		User user1  = (User) authentication.getPrincipal();
//		int id = user1.getId();
		long a=userRepository.count();
		 Optional<User> employee = userRepository.findById((int)a);
		 //System.out.println("count"+userRepository.count());
		// System.out.println("value id"+id);
		 employee.ifPresent(consumer->{
			// user.setName(consumer.getName());
		user.setAccount(consumer.getAccount());
		user.setEmail(consumer.getEmail());
		user.setPassword((consumer.getPassword()));
		//user.setPassword(encoder.encode(consumer.getPassword()));
		user.setId(consumer.getId());
		user.setLastName(consumer.getLastName());
		user.setMobile(consumer.getMobile());
		user.setName(consumer.getName());
		user.setShop(consumer.getShop());
		user.setStatus(consumer.getStatus());
		user.setLine1(consumer.getLine1());
		user.setLine2(consumer.getLine2());
		user.setCity(consumer.getCity());
		user.setCode(consumer.getCode());
		user.setDocument(consumer.getDocument());
		user.setDocnum(consumer.getDocnum());
		user.setAcc(consumer.getAcc());
		user.setAccno(consumer.getAccno());
		user.setBank(consumer.getBank());
		user.setSwift(consumer.getSwift());
		 });
		 //user.setPassword(encoder.encode(user.getPassword()));
		 userRepository.save(user);
	}

	@Override
	public boolean isUserAlreadyPresent(User user) {
		// Try to implement this method, as assignment.
		return false;
	}

//	@Override
//	public List<User> findAll() {
//		 List<User> logs = userRepository.findAll();
//	        return logs;
//	}

}
