describe('Load Posts', () => {
  it('successfully loads', () => {
    cy.visit('http://localhost:5173/posts')
    cy.get('h1').should('have.text', 'Posts')
    cy.contains("Click Me").click()
  })
})
