import React, { useState } from 'react';
import './Navbar.css';
import Sample from './Sample';
import { Link } from 'react-router-dom';
// import black from './Blackpearl.png';
import MenuIcon from '@mui/icons-material/Menu';

function Navbar() {
  const [isDropdownOpen, setDropdownOpen] = useState(false);

  const toggleDropdown = () => {
    setDropdownOpen(!isDropdownOpen);
  };

  return (
    <div>
    <nav>
      <img src="https://images-platform.99static.com//2ll-iSecgRUEMoLZ0RVpIvwzgjs=/800x0:1800x1000/fit-in/590x590/projects-files/36/3667/366728/1f33f30b-cf70-436f-afeb-53e61802340c.JPG" alt="BrandLogo"/>
      <div className="logo">
        <p>Black Pearl</p>
      </div>
      <div className="menu-icon" onClick={toggleDropdown}>
        <MenuIcon style={{height:40,width:40,color:'black',marginRight:0}}/>
      </div>
      {isDropdownOpen && (
        <div className="dropdown-content">
          <Link to="/read">View Books</Link>
          <Link to="/create">Add Books</Link>
          <Link to="/update">Update Books</Link>
          <Link to="/delete">Delete Books</Link>
          {/* Add more navigation links as needed */}
        </div>
      )}
    </nav>
    
    <div><Sample/></div>
    </div>
  );
}

export default Navbar;
