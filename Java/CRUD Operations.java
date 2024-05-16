// CRUD Operations (Create, Read, Update, Delete)

// The RESTful API for managing a collection of users serves as a backend service for user management in an application.

// Create Users: Users can send HTTP POST requests to /api/users with a JSON payload containing user data such as username and email. This endpoint creates a new user in the system.

@PostMapping("/api/users")
public ResponseEntity<User> createUser(@RequestBody User user) {
    User newUser = userRepository.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
}


// Retrieve Users: Users can send HTTP GET requests to /api/users to retrieve a list of all users stored in the system. They can also retrieve a specific user by sending a GET request to /api/users/{id}, where {id} is the ID of the user.

@GetMapping("/api/users")
public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userRepository.findAll();
    return ResponseEntity.ok().body(users);
}

@GetMapping("/api/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    return ResponseEntity.ok().body(user);
}

// Update Users: Users can send HTTP PUT requests to /api/users/{id} with a JSON payload containing updated information about a user. This endpoint updates the specified user's data in the system.

@PutMapping("/api/users/{id}")
public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                       @RequestBody User userDetails) {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    user.setUsername(userDetails.getUsername());
    user.setEmail(userDetails.getEmail());
    final User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
}

// Delete Users: Users can send HTTP DELETE requests to /api/users/{id} to delete a specific user from the system.

@DeleteMapping("/api/users/{id}")
public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    userRepository.delete(user);
    return ResponseEntity.ok().build();
}

// The User Management API provides a CRUD (Create, Read, Update, Delete) interface for managing user data, allowing frontend applications or other services to interact with and manipulate user information.