INSERT INTO public.users
VALUES (1, 'artem', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'BCRYPT')
ON CONFLICT DO NOTHING;
INSERT INTO public.users
VALUES (2, 'pol', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'BCRYPT')
ON CONFLICT DO NOTHING;

INSERT INTO public.authority
VALUES (1, 'ROLE_ADMIN', 1)
ON CONFLICT DO NOTHING;

INSERT INTO public.authority
VALUES (2, 'ROLE_USER', 1)
ON CONFLICT DO NOTHING;

INSERT INTO public.authority
VALUES (3, 'ROLE_USER', 2)
ON CONFLICT DO NOTHING;

insert into public.product
VALUES (1, 'Laptop', '1400', 'USD')
ON CONFLICT DO NOTHING;
