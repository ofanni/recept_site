/*-- Kezdetai receptek hozzáadása
INSERT INTO receptek (cim, adag, hozzavalok, leiras, feltoltes_datum, felhasznalo_id)
VALUES
    ('Tészta', 4, 'tészta, víz, só', 'Főzd meg a tésztát, majd add hozzá a sót és a vizet.', '2024-12-19', 1),
    ('Pörkölt', 6, 'hús, hagyma, fűszerek', 'Süsd meg a húst, add hozzá a hagymát és a fűszereket.', '2024-12-18', 2),
    ('Rakott krumpli', 5, 'krumpli, hús, tojás, tejföl, sajt', 'Rétegezd a főtt krumplit, húst, tojást, és öntsd le tejföllel.', '2024-12-17', 1),
    ('Lencsefőzelék', 4, 'lencse, fűszerek, tejföl', 'Főzd meg a lencsét, fűszerezd, és tálald tejföllel.', '2024-12-16', 2);
-- Felhasználók hozzáadása
INSERT INTO felhasznalo (id, telj_nev, felh_nev, jelszo)
VALUES
    (1, 'Admin',  'admin' ,'jelszo123'),
*/