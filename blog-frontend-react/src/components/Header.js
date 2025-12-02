import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
  return (
    <header>
      <nav>
        <Link to="/">
          <h1>My Blog</h1>
        </Link>
        <div>
          <Link to="/">Home</Link>
          <Link to="/create">Create Post</Link>
          <Link to="/login">Login</Link>
          <Link to="/signup">Sign Up</Link>
        </div>
      </nav>
    </header>
  );
}

export default Header;