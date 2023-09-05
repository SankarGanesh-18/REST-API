import React, { useState } from 'react';
import Axios from 'axios';
import './Update.css'

function Update() {
    const [idbook, setIdbook] = useState("")
    const [nam, setNam] = useState("")
    const [auth, setAuthor] = useState("")
    const [genre,setGenre] = useState("");
    const [desp, setDesp] = useState("")
    const [year,setYear] = useState("")
    const [review, setReview] = useState("")
    const [isSubmitted, setIsSubmitted] = useState(false);

    const handleButtonClick = () => {
      setIsSubmitted(!isSubmitted);
    };
  const handleSubmit = (e) => {
      e.preventDefault();

      Axios.put(`http://localhost:8089/updatereviewbyid/${idbook}`, {
          id:idbook,
          bookName:nam,
          author:auth,
          gen:genre,
          descrip:desp,
          yop:year,
          review:review
  })
  }

  return (
    <div className="App2">
     <header> 
      <div className="logInnform">
            <form onSubmit={handleSubmit}>
                <p>Book Id</p>
                <input
                type="number"
                onChange={(e) => {setIdbook(e.target.value)}}
                />
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
                <div class="btnncontainer">
                    <button id="btn4" type="submit" onClick={handleButtonClick}>Update</button>
                    {isSubmitted && <p id="btn4-text" class="popup-message">Updated Successfully!</p>}
                </div>
            </form>
        </div>
      </header>
    </div>
  );
}

export default Update;
