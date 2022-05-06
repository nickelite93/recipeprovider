import logo from './logo.svg';
import React, { Component } from 'react';
import ShowAllRecipes from "./displayFunctions";
import ButtonAppBar from "./Appbar";

class App extends Component {
  state={
    recipes: []
  };

  async componentDidMount() {
    const response = await fetch("/api/recipe/getAll");
    const body = await response.json();
    this.setState({recipes: body})
  }

  render() {
    const {recipes} = this.state;
    const recipeList = ShowAllRecipes(recipes)

    return (
      <div className="App">
      <header className="App-header">
        <ButtonAppBar/>
        <img src={logo} className="App-logo" alt="logo" />
        <div className="App-intro">
          <h2>Recipes</h2>
          {recipeList}
        </div>
      </header>
    </div>
    )
  }
}

export default App;
