# Blog Frontend React

A modern React blog application with full CRUD functionality and authentication.

## Features

- **Home Page**: Blog post listings with cards, images, and categories
- **Blog Details**: Individual blog post pages with full content
- **Create Post**: Form to create new blog posts with all fields
- **Authentication**: Login and signup pages
- **Responsive Design**: Mobile-friendly layout
- **API Integration**: Connected to backend API at `http://localhost:8080/api/blogs`
- **Modern UI**: Clean design with hover effects and animations

## Prerequisites

- Node.js (v14 or higher)
- Backend API running on `http://localhost:8080`

## Getting Started

1. **Install dependencies:**
   ```bash
   npm install
   ```

2. **Start the development server:**
   ```bash
   npm start
   ```

3. **Open your browser:**
   Navigate to [http://localhost:3000](http://localhost:3000)

## API Integration

The application is configured to work with a backend API:
- **Base URL**: `http://localhost:8080/api/blogs`
- **Proxy**: Configured in `package.json` to handle CORS
- **Endpoints**:
  - `GET /api/blogs` - Fetch all blogs
  - `GET /api/blogs/:id` - Fetch single blog
  - `POST /api/blogs` - Create new blog

## Project Structure

```
src/
├── components/
│   ├── Header.js          # Navigation header with menu
│   ├── Footer.js          # Footer component
│   └── PostCard.js        # Blog post card component
├── pages/
│   ├── Home.js            # Home page with post listings
│   ├── BlogPost.js        # Individual post page
│   ├── CreatePost.js      # Create new post form
│   ├── Login.js           # Login page
│   └── Signup.js          # Signup page
├── services/
│   └── api.js             # API service functions
├── App.js                 # Main app component with routing
├── index.js               # App entry point
└── index.css              # Global styles
```

## Blog Data Structure

The application expects blog posts with the following structure:
```json
{
  "id": 3,
  "title": "Sample Blog Title",
  "shortDescription": "This is a short description",
  "fullDesc": "This is the full description of the blog post",
  "blogImage": "https://example.com/image.jpg",
  "category": "Technology",
  "createdDate": "2025-12-02 11:32:11",
  "modifyDate": "2025-12-02 11:32:11",
  "createdBy": "John Doe"
}
```

## Available Categories

- Technology
- Travel
- Food
- Lifestyle
- Health
- Business
- Education
- Entertainment

## Routes

- `/` - Home page
- `/post/:id` - Blog post details
- `/create` - Create new post
- `/login` - Login page
- `/signup` - Signup page

## Styling

- Modern card-based design
- Responsive grid layout
- Hover effects and animations
- Consistent color scheme
- Mobile-first approach

## Development

- Built with React 18
- Uses React Router for navigation
- Proxy configuration for API calls
- Modern CSS with Flexbox and Grid

## Troubleshooting

**CORS Issues**: Make sure your backend API includes CORS headers or use the proxy configuration.

**API Connection**: Ensure your backend server is running on `http://localhost:8080`.

**Build Issues**: Clear node_modules and reinstall dependencies if needed.