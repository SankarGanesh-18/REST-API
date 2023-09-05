import axios from "axios";
import React from "react";
import { Component } from "react";
import './Details.css'; // Import the CSS file for styling
import DeleteIcon from '@mui/icons-material/Delete';

class Details extends Component {
  state = {
    data: [],
  };

  componentDidMount() {
    axios.get('http://localhost:8089/showreview')
      .then(response => {
        this.setState({ data: response.data });
      })
      .catch(error => {
        console.log(error);
      });
  }

  deleteData(id, d) {
    axios.delete(`http://localhost:8089/ByreviewId/${id}`)
      .then(response => {
        console.log(response);

        const data = this.state.data.filter(item => item.id !== id);
        this.setState({ data });
      });
  }

  render() {
    return (
      <div className="book-card-container">
        {this.state.data.map((book) => (
          <div key={book.id} className="book-card">
            <img src={book.pic} alt={book.bookName} className="book-image" />
            <div className="book-details">
            <div className="delete-button-container">
                <DeleteIcon variant='outlined' onClick={() => this.deleteData(book.id)} />
              </div>
              <h2>{book.bookName}</h2>
              <p><b>Author: </b>{book.author}</p>
              <p><b>Year of Publication: </b>{book.yop}</p>
              <p><b>Description: </b>{book.descrip}</p>
              <p><b>Review: </b>{book.review}</p>
            </div>
          </div>
        ))}
      </div>
    );
  }
}

export default Details;
