import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Main.css'; // Import your CSS file for styling

function Main() {
  const [selectedGenre, setSelectedGenre] = useState('All');
  const [user, setUser] = useState([]);
  const [data, setData] = useState([]);

  const fetchAllGenres = () => {
    axios.get(`http://localhost:8089/showreview`)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  };

  const handleValueChange = (genre) => {
    setSelectedGenre(genre);
    if (genre === 'All') {
      fetchAllGenres();
    } else {
      axios.get(`http://localhost:8089/genre/${genre}`)
        .then((response) => {
          setUser(response.data);
        })
        .catch((error) => {
          console.error('Error fetching data:', error);
        });
    }
  };

  useEffect(() => {
    // Fetch data initially (if needed)
    fetchAllGenres();
  }, []);

  return (
    <div>
      <button onClick={() => handleValueChange('All')}>All genres</button>
      <button onClick={() => handleValueChange("Horror")}>Horror</button>
      <button onClick={() => handleValueChange("Fantasy")}>Fantasy</button>
      <button onClick={() => handleValueChange("Science Fiction")}>Science Fiction</button>
      <button onClick={() => handleValueChange("Mystery")}>Mystery</button>
      <br/><br/>
      <div className="container">
        {selectedGenre === 'All' ? (
          data.map((book) => (
            <div key={book.id} className="card">
              <img src={book.pic} alt={book.bookName} className="card-image" />
              <div className="card-content">
                <h2><b>{book.bookName}</b></h2>
                <p><b>Author:</b> {book.author}</p>
                <p><b>Year of Publication:</b>{book.yop}</p>
                <p><b>Description:</b>{book.descrip}</p>
                <p><b>Review:</b>{book.review}</p>
              </div>
            </div>
          ))
        ) : (
          user.map((book) => (
            <div key={book.id} className="card">
            <img src={book.pic} alt={book.bookName} className="card-image" />
            <div className="card-content">
              <h2><b>{book.bookName}</b></h2>
              <p><b>Author:</b> {book.author}</p>
              <p><b>Year of Publication:</b>{book.yop}</p>
              <p><b>Description:</b>{book.descrip}</p>
              <p><b>Review:</b>{book.review}</p>
            </div>
          </div>
          ))
        )}
      </div>
    </div>
  );
}

export default Main;
