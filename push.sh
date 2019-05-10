comment=${1:-no comment}
branch=${2:-master}
git add -A
git cam "$comment"
git push origin $branch
