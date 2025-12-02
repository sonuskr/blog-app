import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { blogAPI } from '../services/api';

function BlogPost() {
  const { id } = useParams();
  const [post, setPost] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchPost = async () => {
      try {
        const data = await blogAPI.getBlog(id);
        setPost(data);
      } catch (error) {
        console.error('Error fetching post:', error);
      } finally {
        setLoading(false);
      }
    };
    fetchPost();
  }, [id]);

  if (loading) return <div>Loading...</div>;
  if (!post) return <div>Post not found</div>;

  return (
    <article className="blog-post">
      {post.blogImage && (
        <img src={post.blogImage} alt={post.title} className="blog-image" />
      )}
      <div className="blog-header">
        <span className="blog-category">{post.category}</span>
        <h1>{post.title}</h1>
        <div className="blog-meta">
          <small>By {post.createdBy} • {new Date(post.createdDate).toLocaleDateString()}</small>
          {post.modifyDate !== post.createdDate && (
            <small> • Updated {new Date(post.modifyDate).toLocaleDateString()}</small>
          )}
        </div>
      </div>
      <div className="blog-content">
        <p>{post.fullDesc}</p>
      </div>
    </article>
  );
}

export default BlogPost;