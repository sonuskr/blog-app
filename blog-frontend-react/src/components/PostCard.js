import React from 'react';
import { Link } from 'react-router-dom';

function PostCard({ post }) {
  return (
    <div className="post-card">
      {post.blogImage && (
        <img src={post.blogImage} alt={post.title} className="post-image" />
      )}
      <div className="post-content">
        <span className="post-category">{post.category}</span>
        <h3>
          <Link to={`/post/${post.id}`}>{post.title}</Link>
        </h3>
        <p>{post.shortDescription}</p>
        <div className="post-meta">
          <small>By {post.createdBy} • {new Date(post.createdDate).toLocaleDateString()}</small>
        </div>
      </div>
    </div>
  );
}

export default PostCard;