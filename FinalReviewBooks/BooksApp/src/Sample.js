import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Sample.css'; // Import the external CSS file
function Sample() {
  const [details, setDetails] = useState([]);
  const [searchInput, setSearchInput] = useState('');
  const [showDetails, setShowDetails] = useState(false); // State to control whether to show details

  function FetchDetails() {
    console.log("Clicked get");
    axios.get('http://localhost:8089/showreview')
      .then((response) => {
        console.log(response.data)
        setDetails(response.data);
        setShowDetails(true); // Show details when data is fetched
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  }

  const handleChange = (e) => {
    e.preventDefault();
    setSearchInput(e.target.value);
  };

  const filteredData = details.filter((e) => {
    if (searchInput==='') {
      return e; // Return false to exclude null or undefined values
    }
    return e.bookName.toLowerCase().includes(searchInput.toLowerCase());
  });

  useEffect(() => {
    // Fetch data initially (if needed)
    FetchDetails();
  }, []);

  return (
    <div className='home'>
      <img className="Homely" src={"https://cdn.pixabay.com/photo/2017/08/27/17/56/book-2687007_1280.jpg"} alt="Home"/>
      <div className='containerex'>
      <p>"Hello....👋🏻"<br/><br/>"Dive into a world of words and wander through the pages of enchanting stories."</p>
      <input
            type='text'
            className='form-control'
            placeholder='Search book'
            value={searchInput}
            onChange={handleChange}
          />
          </div>
          
          <br/><br/>
        <div className='container1'>
          {showDetails && filteredData.map((details) => (
            <div key={details.id} className='card1'>
              <img src={details.pic} alt="Book Cover" className='card1-image' />
              <div className='card-content'>
              <h2><b>{details.bookName}</b></h2>
                <p><b>Author:</b> {details.author}</p>
                <p><b>Year of Publication:</b>{details.yop}</p>
                <p><b>Description:</b>{details.descrip}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
  );
}

export default Sample;
