function ShowAllRecipes(recipes) {
    return (
        <div style={{display: 'inline-block', alignContent:'center', alignItems: 'center', height: '500', width: '500'}}>
        {recipes.map(recipe =>
            <div key={recipe.id}>
              {recipe.name} <br /> ({recipe.method})
              {recipe.ingredients.map(ingredient =>
              <li key={ingredient.id}>
                {ingredient.name}
              </li>
              )}
            </div>
        )}
        </div>
    )
  }

  export default ShowAllRecipes;