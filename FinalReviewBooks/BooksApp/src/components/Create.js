import React, { useState } from 'react';
import Axios from 'axios';
import './Create.css';

function Create() {
    const [nam, setNam] = useState("")
    const [auth, setAuthor] = useState("")
    const [genre,setGenre] = useState("");
    const [desp, setDesp] = useState("")
    const [year,setYear] = useState("")
    const [picture,setPicture] = useState("")
    const [review, setReview] = useState("")
    const [isSubmitted, setIsSubmitted] = useState(false);

    const handleButtonClick = () => {
      setIsSubmitted(!isSubmitted);
    };
  const handleSubmit = (e) => {
      e.preventDefault();

      Axios.post    ('http://localhost:8089/addreview', {
          bookName:nam,
          author:auth,
          gen:genre,
          descrip:desp,
          yop:year,
          review:review,
          pic:picture
  })
  }


  return (
    <div className="App1">
     <header> 
      <div className="logInn-form">
            <form onSubmit={handleSubmit}>
            
                <p>Book Name</p>
                <input
                  type="text"
                  onChange={(e) => {setNam(e.target.value)}}
                />
                <p> Author</p>
                <input
                  type="text"
                  onChange={(e) => {setAuthor(e.target.value)}}
                />
                <p> Genre </p>
                <input
                  type="text"
                  onChange={(e) => {setGenre(e.target.value)}}
                />
                <p> Description</p>
                <input 
                type="text"
                onChange={(e) => {setDesp(e.target.value)}}
                />
                <p> Year of Publish</p>
                <input 
                type="number"
                onChange={(e) => {setYear(e.target.value)}}
                />
                <p> Review</p>
                <input 
                type="text"
                onChange={(e) => {setReview(e.target.value)}}
                />
                <br/>   
                <p> Image Url</p>
                <input 
                type="text"
                onChange={(e) => {setPicture(e.target.value)}}
                />
                <br/>   
                <div class="btn-container">
                    <button id="btn45" type="submit" onClick={handleButtonClick}>Submit</button>
                    {isSubmitted && <p id="btn45text" class="popupmessage">Added Successfully!</p>}
                </div>
            </form>
        </div>
      </header>
    </div>
  );
}

export default Create;
