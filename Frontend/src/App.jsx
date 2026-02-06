import { useEffect, useState } from 'react'
import ProductList from './components/ProductList.jsx'
import CategoryFilter from './components/CategoryFilter.jsx'
import './App.css'

function App() {
  const [products, setProducts] = useState([])
  const [categories, setCategories] = useState([])
  const [selectedCategory, setSelectedCategory] = useState(null)
  const [searchTerm, setSearchTerm] = useState('')
  const [sortOrder, setSortOrder] = useState('asc')

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(res => res.json())
      .then(data => setProducts(data))
      .catch(err => console.error(err))

    fetch('http://localhost:8080/api/categories')
      .then(res => res.json())
      .then(data => setCategories(data))
  }, [])

  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId)
  }

  const handleSearchChange = (e) => {
    setSearchTerm(e.target.value)
  }

  const handleSortChange = (e) => {
    setSortOrder(e.target.value)
  }

  const filteredProducts = products
    .filter(product => {
      const matchesCategory =
        selectedCategory ? product.category.id === selectedCategory : true

      const matchesSearch =
        product.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
        product.description.toLowerCase().includes(searchTerm.toLowerCase())

      return matchesCategory && matchesSearch
    })
    .sort((a, b) =>
      sortOrder === 'asc' ? a.price - b.price : b.price - a.price
    )

  return (
    <div className="container">
      <h1 className="my-4">Product Catalog</h1>

      <div className="row mb-4">
        <div className="col-md-3">
          <CategoryFilter
            categories={categories}
            onSelect={handleCategorySelect}
          />
        </div>

        <div className="col-md-5">
          <input
            type="text"
            className="form-control"
            placeholder="Search products..."
            value={searchTerm}
            onChange={handleSearchChange}
          />
        </div>

        <div className="col-md-4">
          <select className="form-control" onChange={handleSortChange}>
            <option value="asc">Price: Low → High</option>
            <option value="desc">Price: High → Low</option>
          </select>
        </div>
      </div>

      {filteredProducts.length > 0 ? (
        <ProductList products={filteredProducts} />
      ) : (
        <p>No products found</p>
      )}
    </div>
  )
}

export default App
