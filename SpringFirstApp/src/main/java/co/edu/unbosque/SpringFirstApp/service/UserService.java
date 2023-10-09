package co.edu.unbosque.springfirstapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.springfirstapp.model.User;
import co.edu.unbosque.springfirstapp.repository.UserRepository;

@Service
public class UserService implements CRUDOperation<User> {

	@Autowired
	private UserRepository userRepo;

	public UserService() {

	}

	@Override
	public long count() {
		return userRepo.count();
	}

	@Override
	public boolean exist(Long id) {
		return userRepo.existsById(id) ? true : false;
	}

	@Override
	public int create(User data) {
		if (findUsernameAlreadyTaken(data)) {
			return 1;
		} else {
			userRepo.save(data);
			return 0;
		}
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public int deleteById(Long id) {
		Optional<User> found = userRepo.findById(id);
		if (found.isPresent()) {
			userRepo.delete(found.get());
			return 0;
		} else {
			return 1;
		}
	}
	
	public int deleteByUsername(String username) {
		Optional<User> found = userRepo.findByUsername(username);
		if (found.isPresent()) {
			userRepo.delete(found.get());
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int updateById(Long id, User newData) {
		Optional<User> found = userRepo.findById(id);
		Optional<User> newFound=userRepo.findByUsername(newData.getUsername());
		
		
		if (found.isPresent()&&!newFound.isPresent()) {
			User temp = found.get();
			temp.setUsername(newData.getUsername());
			temp.setPassword(newData.getPassword());
			userRepo.save(temp);
			return 0;
		} if (found.isPresent()&&newFound.isPresent()) {
			return 1;
		} if (!found.isPresent()) {
			return 2;
		} else {
			return 3;
		}
	}

	public User getById(Long id) {
		Optional<User> found = userRepo.findById(id);
		if (found.isPresent()) {
			return found.get();
		}else {
			return null;
		}
	}

	public boolean findUsernameAlreadyTaken(User newUser) {
		Optional<User> found = userRepo.findByUsername(newUser.getUsername());
		if (found.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

}
